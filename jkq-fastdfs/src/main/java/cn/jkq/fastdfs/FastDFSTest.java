package cn.jkq.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;


public class FastDFSTest {

    @Test
    public void test() throws Exception {

        //追踪服务器文件的路径
        String con_filename = ClassLoader.getSystemResource("fastdfs/tracker.conf").getPath();

        //设置全局的配置
        ClientGlobal.init(con_filename);

        //创建trackerClient
        TrackerClient trackerClient = new TrackerClient();

        //创建trackerService
        TrackerServer trackerServer = trackerClient.getConnection();

        //创建storageService,可以为null
        StorageServer storageServer = null;

        //创建存储服务器客户端StorageClient
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);

        //上传文件
        String[] upload_file = storageClient.upload_file("H:\\pictureLocation\\pic\\1535428372983.jpg", "jpg", null);
        if(upload_file !=null && upload_file.length>1){
            for (String s : upload_file) {
                System.out.println(s);
            }
            //获取存储服务器信息
            String groupName = upload_file[0];
            String fileName = upload_file[1];
            ServerInfo[] serverInfos = trackerClient.getFetchStorages(trackerServer, groupName, fileName);
            for (ServerInfo serverInfo : serverInfos) {
                System.out.println("ip="+serverInfo.getIpAddr()+";port="+serverInfo.getPort());
            }
            //组合可以访问的路径
            String url = "http://"+serverInfos[0].getIpAddr()+"/"+groupName+"/"+fileName;
            System.out.println(url);
        }
    }
}
