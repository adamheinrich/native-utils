# Native Utils
A simple library class which helps with loading dynamic libraries stored in the JAR archive. These libraries usualy contain implementation of some methods in native code (using JNI - Java Native Interface).

## Notes
 * The temporary file is stored into temp directory specified by java.io.tmpdir (by default it’s the operating system’s temporary directory). It should be automatically deleted when the application exits.
 * Although the code has some try-finally section (to be sure that streams are closed properly in case an exception is thrown), it does not catch exceptions. The exception has to be handled by the application. I belive this approach is cleaner and has some benefits.

## Usage
To load the dynamic library, just make sure it is packed inside the JAR archive and call method loadLibraryFromJar:

    import cz.adamh.NativeUtils;
     
    public class HelloJNI {  
        static {   
            try {    
                NativeUtils.loadLibraryFromJar("/resources/libHelloJNI.so");   
            } catch (IOException e) {
                // This is probably not the best way to handle exception :-)    
                e.printStackTrace();
            }    
        }  
     
        public native void hello();    
    }

## More information
More information can be found in accompanying [blog post][1].

[1]: https://www.adamheinrich.com/blog/2012/12/how-to-load-native-jni-library-from-jar/

## Maven

You need a Github account and a personal access token to build against Github's Maven Repo.

Add the following dependency and repository to your pom.xml:

    <dependencies>
        ...
        <dependency>
            <groupId>cz.adamh.utils</groupId>
            <artifactId>native-utils</artifactId>
            <version>1.0</version>
        </dependency>
    </dependencies>
    ...
    <repositories>
        <repository>
            <id>github</id>
            <name>GitHub regwhitton Apache Maven Packages</name>
            <url>https://maven.pkg.github.com/regwhitton/native-utils</url>
        </repository>
    </repositories>

Create a Github personal access token. See [Creating a personal access token for the command line](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line)

Edit your ~/.m2/settings.xml and add a server entry.

    <settings ...>
        ...
        <servers>
            <server>
                <id>github</id>
                <username>your_github_username</username>
                <password>your_github_access_token</password>
            </server>
        </servers>
        ...
    </settings>

