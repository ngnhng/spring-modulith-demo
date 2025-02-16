package com.ngnhng.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator

@SpringBootApplication
@ComponentScan(
    basePackages = ["com.ngnhng.demo", "com.ngnhng.demo.order"],
    nameGenerator = FullyQualifiedAnnotationBeanNameGenerator::class
)
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

