package de.markusbordihn.materialelements;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotations {

  @Retention(RetentionPolicy.SOURCE)
  public @interface TemplateEntryPoint {
    String value() default "";
  }

}
