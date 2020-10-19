package be.howest.ti.design.patterns.state.file;

public class ReadFile {

    public static void main(String[] args) {
        File f = new File();

        f.open();
        System.out.println(f.readContent());
        f.close();

    }

}
