package br.com.postechfiap.jlapp.shared.logger.log;

public interface Logger {

    void info(final String format,
              final Object... arguments);

    void warn(final String format,
              final Object... arguments);

    void error(final String format,
               final Object... arguments);

    void debug(final String format,
               final Object... arguments);

}
