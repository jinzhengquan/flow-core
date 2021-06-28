package cn.flow.engine.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommandExecutorImpl implements CommandExecutor {
    private final CommandInterceptor commandInterceptor;

    @Override
    public <T> T execute(Command<T> command) {
        return commandInterceptor.execute(command);
    }
}
