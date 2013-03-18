/*****************************************************
 * WARNING: this file was generated by -e
 * on Thu Mar 14 00:20:16 2013.
 * Any changes made here will be LOST.
 *****************************************************/

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Uptime_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Uptime_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_uptime_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_uptime_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_UPTIME(cls);



    JAVA_SIGAR_SET_FIELDS_UPTIME(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DirStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DirStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_dir_stat_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_dir_stat_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_DIRSTAT(cls);



    JAVA_SIGAR_SET_FIELDS_DIRSTAT(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ResourceLimit_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ResourceLimit_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_resource_limit_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_resource_limit_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_RESOURCELIMIT(cls);



    JAVA_SIGAR_SET_FIELDS_RESOURCELIMIT(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsServerV3_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsServerV3_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_nfs_server_v3_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_nfs_server_v3_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NFSSERVERV3(cls);



    JAVA_SIGAR_SET_FIELDS_NFSSERVERV3(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_FileAttrs_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_FileAttrs_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_file_attrs_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_file_attrs_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_FILEATTRS(cls);



    JAVA_SIGAR_SET_FIELDS_FILEATTRS(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Cpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Cpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_cpu_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_cpu_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_CPU(cls);



    JAVA_SIGAR_SET_FIELDS_CPU(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsClientV2_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsClientV2_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_nfs_client_v2_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_nfs_client_v2_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NFSCLIENTV2(cls);



    JAVA_SIGAR_SET_FIELDS_NFSCLIENTV2(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DiskUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DiskUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_disk_usage_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_disk_usage_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_DISKUSAGE(cls);



    JAVA_SIGAR_SET_FIELDS_DISKUSAGE(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Swap_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Swap_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_swap_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_swap_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_SWAP(cls);



    JAVA_SIGAR_SET_FIELDS_SWAP(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcTime_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcTime_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_time_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_time_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCTIME(cls);



    JAVA_SIGAR_SET_FIELDS_PROCTIME(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_FileSystemUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_FileSystemUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_file_system_usage_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_file_system_usage_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_FILESYSTEMUSAGE(cls);



    JAVA_SIGAR_SET_FIELDS_FILESYSTEMUSAGE(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcMem_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcMem_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_mem_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_mem_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCMEM(cls);



    JAVA_SIGAR_SET_FIELDS_PROCMEM(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ThreadCpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ThreadCpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_thread_cpu_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_thread_cpu_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_THREADCPU(cls);



    JAVA_SIGAR_SET_FIELDS_THREADCPU(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_proc_stat_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_stat_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCSTAT(cls);



    JAVA_SIGAR_SET_FIELDS_PROCSTAT(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInterfaceConfig_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInterfaceConfig_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_net_interface_config_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_net_interface_config_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NETINTERFACECONFIG(cls);



    JAVA_SIGAR_SET_FIELDS_NETINTERFACECONFIG(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInfo_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInfo_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_net_info_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_net_info_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NETINFO(cls);



    JAVA_SIGAR_SET_FIELDS_NETINFO(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_SysInfo_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_SysInfo_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_sys_info_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_sys_info_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_SYSINFO(cls);



    JAVA_SIGAR_SET_FIELDS_SYSINFO(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Mem_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Mem_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_mem_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_mem_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_MEM(cls);



    JAVA_SIGAR_SET_FIELDS_MEM(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsClientV3_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsClientV3_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_nfs_client_v3_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_nfs_client_v3_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NFSCLIENTV3(cls);



    JAVA_SIGAR_SET_FIELDS_NFSCLIENTV3(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DirUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_DirUsage_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_dir_usage_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_dir_usage_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_DIRUSAGE(cls);



    JAVA_SIGAR_SET_FIELDS_DIRUSAGE(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Tcp_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_Tcp_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_tcp_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_tcp_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_TCP(cls);



    JAVA_SIGAR_SET_FIELDS_TCP(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInterfaceStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NetInterfaceStat_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jstring jname)
{
    sigar_net_interface_stat_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    const char *name;
    dSIGAR_VOID;

    name = jname ? JENV->GetStringUTFChars(env, jname, 0) : NULL;

    status = sigar_net_interface_stat_get(sigar, name, &s);

    if (jname) JENV->ReleaseStringUTFChars(env, jname, name);

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NETINTERFACESTAT(cls);



    JAVA_SIGAR_SET_FIELDS_NETINTERFACESTAT(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCred_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCred_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_cred_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_cred_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCCRED(cls);



    JAVA_SIGAR_SET_FIELDS_PROCCRED(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcFd_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcFd_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_fd_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_fd_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCFD(cls);



    JAVA_SIGAR_SET_FIELDS_PROCFD(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCredName_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCredName_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_cred_name_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_cred_name_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCCREDNAME(cls);



    JAVA_SIGAR_SET_FIELDS_PROCCREDNAME(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcCpu_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_cpu_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_cpu_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCCPU(cls);



    JAVA_SIGAR_SET_FIELDS_PROCCPU(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsServerV2_gather
(JNIEnv *env, jobject obj, jobject sigar_obj);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_NfsServerV2_gather
(JNIEnv *env, jobject obj, jobject sigar_obj)
{
    sigar_nfs_server_v2_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_nfs_server_v2_get(sigar,&s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_NFSSERVERV2(cls);



    JAVA_SIGAR_SET_FIELDS_NFSSERVERV2(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcState_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcState_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_state_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_state_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCSTATE(cls);



    JAVA_SIGAR_SET_FIELDS_PROCSTATE(cls, obj, s);
}

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcExe_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid);

JNIEXPORT void JNICALL Java_org_hyperic_sigar_ProcExe_gather
(JNIEnv *env, jobject obj, jobject sigar_obj, jlong pid)
{
    sigar_proc_exe_t s;
    int status;
    jclass cls = JENV->GetObjectClass(env, obj);
    
    dSIGAR_VOID;

    

    status = sigar_proc_exe_get(sigar, pid, &s);

    

    if (status != SIGAR_OK) {
        sigar_throw_error(env, jsigar, status);
        return;
    }



    JAVA_SIGAR_INIT_FIELDS_PROCEXE(cls);



    JAVA_SIGAR_SET_FIELDS_PROCEXE(cls, obj, s);
}
