import net.labymod.labygradle.common.extension.LabyModAnnotationProcessorExtension.ReferenceType

dependencies {
    labyProcessor()
    api(project(":api"))
    addonMavenDependency("com.squareup.okhttp3:okhttp:4.12.0")
    addonMavenDependency("org.apache.commons:commons-csv:1.9.0")
}

labyModAnnotationProcessor {
    referenceType = ReferenceType.DEFAULT
}