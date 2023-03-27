package ex2;

public class DenyAccess implements DenyOption {
    @Override
    public void execute(String url) throws Exception {
        System.out.println(url + "DenyAccess.execute");
    }
}



