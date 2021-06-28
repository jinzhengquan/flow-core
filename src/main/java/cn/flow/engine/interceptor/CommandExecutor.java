package cn.flow.engine.interceptor;

public interface CommandExecutor {
    <T> T execute(Command<T> command);
}