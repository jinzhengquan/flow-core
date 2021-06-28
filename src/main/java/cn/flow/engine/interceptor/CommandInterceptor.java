package cn.flow.engine.interceptor;

public interface CommandInterceptor {

    <T> T execute(Command<T> command);

    CommandInterceptor getNext();

    void setNext(CommandInterceptor next);

}
