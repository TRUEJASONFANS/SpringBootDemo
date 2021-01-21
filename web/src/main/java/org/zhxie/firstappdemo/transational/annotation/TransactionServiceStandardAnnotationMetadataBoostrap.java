package org.zhxie.firstappdemo.transational.annotation;


import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@TransactionalService
public class TransactionServiceStandardAnnotationMetadataBoostrap {

    public static void main(String[] args) {
        AnnotationMetadata annotationMetadata = new
                StandardAnnotationMetadata(TransactionServiceStandardAnnotationMetadataBoostrap.class);

        Set<String> metaAnnotationTypes =
                annotationMetadata.getAnnotationTypes().stream().map(annotationMetadata::getMetaAnnotationTypes)
                .collect(LinkedHashSet::new, Set::addAll, Set::addAll);

        metaAnnotationTypes.forEach(metaAnnotation -> {
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(metaAnnotation);
            if (!CollectionUtils.isEmpty((annotationAttributes))) {
                annotationAttributes.forEach((name, val) -> System.out.printf(
                        "注解@ %s是属性 %s = %s \n", ClassUtils.getShortName(metaAnnotation), name,val));
            }
        });



    }

}
