package edu.java.deipss.common.util;

import org.apache.logging.log4j.util.Strings;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidUtil<T> {
    public static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> String check(T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.size() > 0) {
            List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            return Strings.join(collect, ',');

        }
        return null;
    }

    public static <T> String check(T t) {
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (validate.size() > 0) {
            List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            return Strings.join(collect, ',');

        }
        return null;
    }

    public static <T> void checkAndThrow(T t) throws Exception {
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (validate.size() > 0) {
            List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception(Strings.join(collect, ','));
        }
    }

    public static <T> void checkAndThrow(T t, Class<?>... groups) throws Exception {
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.size() > 0) {
            List<String> collect = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            throw new Exception(Strings.join(collect, ','));
        }
    }
}
