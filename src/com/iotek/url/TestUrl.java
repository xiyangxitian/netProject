package com.iotek.url;

public class TestUrl {
    public static void main(String[] args) {
//        UrlUtil.downLoad("http://p0.so.qhimgs1.com/sdr/200_200_/t0195caf55de65163a0.jpg", "e:/io", "preetyGirl.jpg");
//        UrlUtil.downLoad("http://dl.image.so.com/d?imgurl=http%3A%2F%2Fp0.so.qhimgs1.com%2Ft0195caf55de65163a0.jpg&purl=http%3A%2F%2Fimage.so.com%2F%3Fsrc%3Ddl.image&key=5e737122eb", "e:/io", "pretyGirl3.jpg");
        //测试提取百度网盘中的图片
        String url = "https://pan.baidu.com/s/1jDARpiZ6d2hvcuxQwbJlgA";
        String downUrl = "https://nj02all01.baidupcs.com/file/7a338e6951434c2a7b1f65a611244d92?bkt=p3-14007a338e6951434c2a7b1f65a611244d926e37f22d000000013ce7&fid=3809237834-250528-663129428487843&time=1552355281&sign=FDTAXGERLQBHSKfW-DCb740ccc5511e5e8fedcff06b081203-ZkDPSrY8QsYgmCYiFc4SB87rwYQ%3D&to=69&size=81127&sta_dx=81127&sta_cs=1&sta_ft=jpg&sta_ct=7&sta_mt=6&fm2=MH%2CNanjing02%2CAnywhere%2C%2Cguangdong%2Ccnc&ctime=1396719117&mtime=1527149769&resv0=cdnback&resv1=0&vuk=3809237834&iv=0&htype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=14007a338e6951434c2a7b1f65a611244d926e37f22d000000013ce7&sl=68616270&expires=8h&rt=sh&r=365224220&mlogid=1632968340642059280&vbdid=4156414890&fin=abea88dcbcf898f4827451bcd9e2d361.jpg&fn=abea88dcbcf898f4827451bcd9e2d361.jpg&rtype=1&dp-logid=1632968340642059280&dp-callid=0.1.1&hps=1&tsl=200&csl=200&csign=Xhdw5%2BOhCavoCuw%2B2d0qZgJ1PtU%3D&so=0&ut=6&uter=4&serv=0&uc=4192912830&ti=54c943154d862903b9e64f8040e71d1b5c1a6facb66ea8a2&by=themis";
        UrlUtil.downLoad(downUrl, "e:/io", "pretyGirl5.jpg");
    }
}
