package com.lss233.phoenix.orm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Annotation that identifies a field in a
 *  class that corresponds to a column in the
 *  database and will be persisted.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    /**
     * The name of the column in the database. If not set then the name is taken from the field name.
     */
    String name() default "";

    /**
     * The DataType associated with the field. If not set then the Java class of the field is used to match with the
     * appropriate DataType. This should only be set if you are overriding the default database type or if the field
     * cannot be automatically determined (ex: byte[]).
     */
    DataType dataType() default DataType.UNKNOW;

    /**
     * The default value of the field for creating the table. Default is none.
     */
    String defaultValue() default "";

    /**
     * Set this to be true (default false) to have the database add an index for this field.
     */
    boolean index() default false;

    /**
     * Set this to be true (default false) to have the database insure that the column is unique to all rows in the
     * table. Use this when you wan a field to be unique even if it is not the identify field. For example, if you have
     * the firstName and lastName fields, both with unique=true and you have "Bob", "Smith" in the database, you cannot
     * insert either "Bob", "Jones" or "Kevin", "Smith".
     */
    boolean unique() default false;

    /**
     * Whether the field can be assigned to null or have no value. Default is true.
     */
    boolean require() default true;

}
