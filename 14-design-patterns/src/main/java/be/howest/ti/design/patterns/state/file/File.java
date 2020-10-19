package be.howest.ti.design.patterns.state.file;

import java.util.logging.Logger;

public class File implements FileState {

    private FileState state = new ClosedFile();

    @Override
    public void open() {
        Logger.getAnonymousLogger().info("open");
        state.open();
    }

    @Override
    public String readContent() {
        Logger.getAnonymousLogger().info("read");
        return state.readContent();
    }

    @Override
    public void close() {
        Logger.getAnonymousLogger().info("close");
        state.close();
    }

    private class OpenFileState implements FileState {
        @Override
        public void open() {
            throw new IllegalStateException("im already open");
        }

        @Override
        public String readContent() {
            return "To be or not to be.";
        }

        @Override
        public void close() {
            state = new ClosedFile();
        }
    }

    private class ClosedFile implements FileState {

        @Override
        public void open() {
            state = new OpenFileState();
        }

        @Override
        public String readContent() {
            throw new IllegalStateException("im closed");
        }

        @Override
        public void close() {
            throw new IllegalStateException("im already closed");
        }
    }
}
