package application.utils;

import java.util.Objects;

public class Logger {

   private static Logger instance = null;
   private final org.apache.log4j.Logger logLogger;

   private Logger() {
      logLogger = org.apache.log4j.Logger.getLogger("rootLogger");
      instance = this;
   }

   public static Logger get() {
      return Objects.requireNonNullElseGet(instance, Logger::new);
   }

   public Logger init() {
      return this;
   }

   public void logStep(String description, Object... args) {
      info(String.format("--------- Step : %s", String.format(description, args)));
   }

   public void info(String message, Object... args) {
      logLogger.info(String.format(message, args));
   }

}
