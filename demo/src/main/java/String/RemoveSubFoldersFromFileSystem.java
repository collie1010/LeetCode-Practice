package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromFileSystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        
        List<String> result = new ArrayList<>();
        result.add(folder[0]);

        
        for (int i = 1; i < folder.length; i++) {
            String lastFolder = result.get(result.size() - 1) + "/";
            System.out.println("Checking folder: " + folder[i] + " against lastFolder: " + lastFolder);
            if (!folder[i].startsWith(lastFolder)) {
                result.add(folder[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RemoveSubFoldersFromFileSystem solution = new RemoveSubFoldersFromFileSystem();
        String[] folders = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> result = solution.removeSubfolders(folders);
        System.out.println(result); // Output: ["/a", "/c/d", "/c/f"]
    }
}
