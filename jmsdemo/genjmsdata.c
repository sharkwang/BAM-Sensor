#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define random(x) (rand()%x)

char *address[20] = {
"达州",
"德阳",
"乐山",
"雅安",
"眉山",
"资阳",
"内江",
"自贡",
"宜宾",
"绵阳",
"南充",
"攀枝花",
"广元",
"泸州",
"遂宁",
"广安",
"巴中",
"阿坝",
"凉山",
"甘孜"
};

char *operation[4] = {
"开户",
"取款",
"转账","存款"
};

char *users[40] = {

"程淑嬌",
"张雪",
"彭施施",
"李可",
"刘湾湾",
"吴铭",
"张涵涵",
"裴培",
"冯韶涵",
"張哓葒",
"苏燕明",
"唐佳丽",
"庄玉娇",
"海云",
"徐叶青",
"琪琪",
"艾琳",
"许艺凡",
"韩林",
"娜娜",
"郑丽",
"黄瑶",
"于玩",
"杨丽岚",
"杨艳",
"潘德珍",
"徐水英",
"周海燕",
"黄英",
"韩琴琴",
"郭琦",
"舒倩霞",
"朱文娟",
"莫有志",
"張麗菊",
"何赛莲",
"张艳芳",
"叶小雯",
"彭丹洁",
"何雯"
};

char *tradesystem[3] = {
"自助终端",
"柜面",
"网银"
};

double rnd(void)
{
	static int fg=1;
	int rd;
	if (fg) {
		srand(time(NULL));
		fg=0;
	}

	return (double)(rand()%1000000+4000000)/100;
}

void Get_Start_End_Time(time_t inittime, char *starttime, char *endtime, int *pass)
{
	char szTime[20];
	struct tm tm1;
	
	int t;

        tm1 = *localtime(&inittime);
	t = random(23);
	
	if ( t < 1)
		t = 9;
	else if ( t == 4 || t == 5)
		t = 10; 
	else if ( t == 22) 
		t = 15;
	else if ( t == 23) 
		t = 19;

	tm1.tm_hour = t;
	
	tm1.tm_min = random(59);
	tm1.tm_sec = random(59);
	
        sprintf( starttime, "%4.4d-%2.2d-%2.2d %2.2d:%2.2d:%2.2d",
                     tm1.tm_year+1900, tm1.tm_mon+1, tm1.tm_mday,
                         tm1.tm_hour, tm1.tm_min,tm1.tm_sec);

	*pass = random(60);
	t = tm1.tm_min = tm1.tm_min + *pass;

	if (t < 60){
		tm1.tm_min = t;
	}
	else{
		tm1.tm_hour += t/60;
		tm1.tm_min  = t%60; 
	}
	
        sprintf( endtime, "%4.4d-%2.2d-%2.2d %2.2d:%2.2d:%2.2d",
                     tm1.tm_year+1900, tm1.tm_mon+1, tm1.tm_mday,
                         tm1.tm_hour, tm1.tm_min,tm1.tm_sec);

}

/*
generate single line: like
[<?xml version="1.0" encoding="UTF8"?><data><trade-ID>cd333</trade-ID><system>Kernel</system><department>Deyang</department><workerID>Tester2</workerID><state>success</state><starttime>2011-11-29 16:22:33</starttime><endtime>2011-11-29 16:36:22</endtime><minute-diff>14</minute-diff> <trade-num>Create</trade-num></data>
]

*/
void genLineData(char *line)
{

	char starttime[20];
	char endtime[20];
	int  pass;

	starttime[0] = '\0';
	endtime[0] = '\0';

	Get_Start_End_Time(time(0), starttime, endtime, &pass);

	sprintf(line,"<?xml version=\"1.0\" encoding=\"UTF8\"?><data><trade-ID>cd3%2.2d</trade-ID><system>%s</system><department>%s</department><workerID>%s</workerID>,<client>%5.5d</client>,<account>%5.5d</account>,<amount>%.2f</amount>,<state>success</state><starttime>%s</starttime><endtime>%s</endtime><minute-diff>%d</minute-diff><trade-num>%s</trade-num></data>",
		random(99), /* trade-ID */
		tradesystem[random(3)], /* tradesystem */
		address[random(20)], 
		users[random(40)],
		random(10000), /*  client */
		random(50000), /* account */
		rnd(), 	/* amount */
		starttime, 
		endtime, 
		pass, 
		operation[random(4)] ); /* operation */


}

/*
genjmsdata [File] [line] 
*/
int main(argc, argv)
int argc;
char *argv[];
{


	FILE *fp;
	int  Line;
	char linebuff[1000];


	if (argc != 3){
	   printf("Usage: genjmsdata [File] line\n");
	   exit(0);
	};

     	srand((int)time(0));


        if((fp=fopen(argv[1],"w"))==NULL) /* 打开一个由argv[1]所指的文件*/
        {
            printf("DataFile: %s can not open\n", argv[1]);
            exit(0);
        }

	Line = atoi(argv[2]);

     	for(int x = 0; x < Line; x ++){
		linebuff[0]='\0';
		genLineData(linebuff);
		fprintf(fp,"%s\n",linebuff);
		printf("testline:[%s]\n", linebuff);
		
	};

	fclose(fp);
}


