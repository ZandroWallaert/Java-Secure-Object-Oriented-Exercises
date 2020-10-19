package be.howest.ti.design.patterns.state.file;

public interface FileState {

    void open();
    String readContent();
    void close();


}
