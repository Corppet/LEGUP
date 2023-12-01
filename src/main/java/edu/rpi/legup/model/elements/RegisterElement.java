package edu.rpi.legup.model.elements;

import java.lang.annotation.ElementType;
import java.lang.annotation.*;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisterElement {

}
