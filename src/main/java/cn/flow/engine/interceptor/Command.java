package cn.flow.engine.interceptor;

public interface Command<T> {
    T execute(CommandContext commandContext);
}