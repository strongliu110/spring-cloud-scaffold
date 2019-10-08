import org.slf4j.MDC;

/**
 * MDC实现日志跟踪
 * https://blog.csdn.net/dwyane__wade/article/details/79978747
 */
public class Logger {
    public void errorWithErrorCode(final String errorCode, String msg, Throwable t) {
        commonLogger(() -> {
            StringBuilder errorCodeStr = new StringBuilder();
            errorCodeStr.append("[").append(errorCode).append("]");
            MDC.put("X-SCAFFOLD_ERROR_CODE", errorCodeStr.toString());
            log.error(msg, t);
            MDC.remove("X-SCAFFOLD_ERROR_CODE");
        });
    }

    private void commonLogger(NoOpLogger noOpLogger) {
        noOpLogger.doNoOp();
    }
}
