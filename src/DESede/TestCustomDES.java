package DESede;



public class TestCustomDES {

    public static void main(String[] args){
        String origin="Android将军->GeneralAndroid->主博客地址：https://blog.csdn.net/android_jiangjun";
        System.out.println("原文：\n"+origin);
        CustomDES customDES=new CustomDES("密码学专栏",origin);
        byte[] c=customDES.deal(origin.getBytes(),1);
        System.out.println("密文：\n"+new String(c));
        byte[]p=customDES.deal(c,0);
        byte[] p_d=new byte[origin.getBytes().length];
        System.arraycopy(p,0,p_d,0,origin.getBytes().length);
        System.out.println("明文：\n"+new String(p));

    }
    /***代码运行结果：
     *
     原文：
     Android将军->GeneralAndroid->主博客地址：https://blog.csdn.net/android_jiangjun
     密文：
     ��Lm����=��� 4�zf4�����zj���}���~Dͪn�B��t���Du��U*e�VxC�̃Ynh\@NH ˙P�Ka�1y~4
     明文：
     Android将军->GeneralAndroid->主博客地址：https://blog.csdn.net/android_jiangjun
     *
     * **/
}
