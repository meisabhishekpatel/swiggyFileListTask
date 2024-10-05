import java.io.File;

public class fileLister {
    
    public static void listFiles(String directoryPath) {
        File directory = new File(directoryPath);

        // Checking if the directory exists and is a valid directory
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                // Iterate through all files
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName() + " - Size: " + file.length() + " bytes");
                    }
                }
            } else {
                System.out.println("The directory is empty or an error occurred while accessing: " + directoryPath);
            }
        } else {
            System.out.println("Invalid directory path: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        // Fetch directory path from environment variables or use a default value
        String directoryPath = System.getenv("FILE_DIRECTORY_PATH");

        if (directoryPath == null || directoryPath.isEmpty()) {
            System.out.println("Environment variable FILE_DIRECTORY_PATH not set. Using current path to list.");
            directoryPath = System.getProperty("user.dir");
        }

        System.out.println("Listing files in directory: " + directoryPath);

        // List files in the specified directory
        listFiles(directoryPath);
    }
}
