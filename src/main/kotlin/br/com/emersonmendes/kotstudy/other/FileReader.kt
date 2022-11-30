import java.io.File

fun readFile() {

    File("/home/emerson/development/projects/kotstudy/src/main/resources/data.txt").reader().forEachLine {
        println(it)
    }

}
