import java.io.File;

public class MakeMyDir {
    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\工作\\论文\\期刊论文\\";
        for (int i=2014;i<=2018;i++) {
            for (int j=1; j<=12; j++) {
                String dir="";
                if(j<=9) {
                    dir= String.valueOf(i) + String.valueOf(0)+ String.valueOf(j);
                } else {
                    dir= String.valueOf(i) + String.valueOf(j);
                }
                String dirpath = path + dir;
                File file = new File(dirpath);
                boolean result = file.mkdirs();
                System.out.println("Status = " + result);
                String subdirpath1 = dirpath + "\\计算机学报";
                String subdirpath2 = dirpath + "\\软件学报";
                String subdirpath3 = dirpath + "\\计算机研究与发展";
                String subdirpath4 = dirpath + "\\中国科学：信息科学";
                File subdir1 = new File(subdirpath1);
                File subdir2 = new File(subdirpath2);
                File subdir3 = new File(subdirpath3);
                File subdir4 = new File(subdirpath4);
                subdir1.mkdir();
                subdir2.mkdir();
                subdir3.mkdir();
                subdir4.mkdir();

            }
        }

    }
}
