package sensorclient;

import java.io.*;
import java.util.Hashtable;
 
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/** This example shows how to establish a connection
 * and send messages to the JMS queue. The classes in this
 * package operate on the same JMS queue. Run the classes together to
 * witness messages being sent and received, and to browse the queue:
 * for messages. The class is used to send messages to the queue.
 *
 * @author Copyright (c) 1999,2010, Oracle and/or its affiliates. All Rights Reserved.
 */
public class QueueSend
{
  // Defines the JNDI context factory.
  public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";

  // Defines the JMS context factory.
  public final static String JMS_FACTORY="jms.SensorConnectionFactory";

  // Defines the queue.
  public final static String QUEUE="jms.SensorQueue";

  private QueueConnectionFactory qconFactory;
  private QueueConnection qcon;
  private QueueSession qsession;
  private QueueSender qsender;
  private Queue queue;
  private TextMessage msg;

  /**
   * Creates all the necessary objects for sending
   * messages to a JMS queue.
   *
   * @param ctx JNDI initial context
   * @param queueName name of queue
   * @exception NamingException if operation cannot be performed
   * @exception JMSException if JMS fails to initialize due to internal error
   */
  
  public void init(Context ctx, String queueName)
    throws NamingException, JMSException
  {
    qconFactory = (QueueConnectionFactory) ctx.lookup(JMS_FACTORY);
    qcon = qconFactory.createQueueConnection();
    qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
    queue = (Queue) ctx.lookup(queueName);
    qsender = qsession.createSender(queue);
    msg = qsession.createTextMessage();
    qcon.start();
  }

  /**
   * Sends a message to a JMS queue.
   *
   * @param message  message to be sent
   * @exception JMSException if JMS fails to send message due to internal error
   */
  public void send(String message) throws JMSException {
    msg.setText(message);
    qsender.send(msg);
  }

  /**
   * Closes JMS objects.
   * @exception JMSException if JMS fails to close objects due to internal error
   */
  public void close() throws JMSException {
    qsender.close();
    qsession.close();
    qcon.close();
  }
  /** main() method.
  *
  * @param args WebLogic Server URL
  * @exception Exception if operation fails
  */

   public static void main(String[] args) throws Exception
    {
        String fileName = "";
		String WLS_url = "";
		String line = "";
		int	loop = 1;
		int sleeptime = 1000;
		
        try
        {

		System.out.println("Usage: java sensorclient.QueueSend WebLogicURL File repeatNum sleeptime");

		if( args.length != 4 )
            	{
			return;
            	}	
			
		WLS_url = args[0];
            	fileName = args[1];            
		loop =  Integer.parseInt(args[2]);
		sleeptime = Integer.parseInt(args[3]) * 1000;
		
		InitialContext ic = getInitialContext(WLS_url);
		QueueSend qs = new QueueSend();
		qs.init(ic, QUEUE);

            	// Create a new random access file.
           	File raf = new File(fileName);
		InputStreamReader read = new InputStreamReader (new FileInputStream(raf),"UTF-8");
		BufferedReader reader = new BufferedReader(new FileReader(raf));

            	long fileLength = raf.length()-1;
			
		while((line=reader.readLine())!=null){

				System.out.println("line: " + line);
				
				if (line != null && line.trim().length() != 0) {
					qs.send(line);
				}

				Thread.sleep(sleeptime);
				
			}
			
		// Close the queue.
		qs.close();

        }
        catch (IOException ex)
        {
            System.out.println(ex.toString());
        }
    }

  private static InitialContext getInitialContext(String url)
    throws NamingException
  {
    
		Hashtable<String,String> env = new Hashtable<String,String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		env.put(Context.SECURITY_PRINCIPAL, "weblogic");
		env.put(Context.SECURITY_CREDENTIALS, "welcome1");

		return new InitialContext(env);
    
  }

}

