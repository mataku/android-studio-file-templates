package util

fun String.slashedPackageName(): String {
    return replace(".", "/")
}