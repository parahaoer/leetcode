package DESede;

public class TestDESedeCrypt {
    public static void main(String[] args) {

        try {
            DESedeCrypt deSedeCrypt = new DESedeCrypt();
            byte[] bkey =EncryptUtils.GetKeyBytes("abcd1234");
            deSedeCrypt.init(false, "DESede", bkey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
