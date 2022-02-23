import Model.NoteModel;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        NoteRepository repository = new NoteRepository();
        Scanner menuScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an operation: ");
            System.out.println(
                    "1- Add note\n" +
                            "2- Update note\n" +
                            "3- Delete note\n" +
                            "4- Find note\n" +
                            "5- Get all notes\n"
            );

            int selection = Integer.parseInt(menuScanner.next());
            switch (selection) {
                case 1: {
                    // Add note
                    String id = UUID.randomUUID().toString();
                    NoteModel newNote = new NoteModel(id);

                    System.out.println("Enter note title:");
                    newNote.setTitle(menuScanner.next());

                    System.out.println("Enter note content:");
                    newNote.setContent(menuScanner.next());

                    newNote.setPublishDateInMillis(System.currentTimeMillis());

                    repository.add(newNote);

                    System.out.println("Note saved");
                    repository.addDate();
                    break;
                }
                case 2: {
                    // Update note by index of list

                    List<NoteModel> notes = repository.getAll();
                    if (notes.isEmpty()) {
                        System.out.println("There is no any note here");
                        break;
                    }

                    repository.search("Enter index which you want to update...");
                    int index = Integer.parseInt(menuScanner.next()) - 1;

                    String targetId = notes.get(index).getId();

                    System.out.println("Enter new title");
                    String updatedTitle = menuScanner.next();

                    System.out.println("Enter new content");
                    String updatedContent = menuScanner.next();

                    NoteModel newNote = new NoteModel(targetId);
                    newNote.setTitle(updatedTitle);
                    newNote.setContent(updatedContent);
                    newNote.setPublishDateInMillis(System.currentTimeMillis());

                    repository.update(targetId, newNote);

                    System.out.println("Note updated");
                    repository.addDate();
                    break;
                }
                case 3: {
                    // Delete note
                    List<NoteModel> notes = repository.getAll();
                    if (notes.isEmpty()) {
                        System.out.println("There is no any note here");
                        break;
                    }
                    repository.search("Enter index which you want to delete...");
                    int index = Integer.parseInt(menuScanner.next()) - 1;

                    String targetId = notes.get(index).getId();

                    repository.delete(targetId);

                    System.out.println("Deleted successfully!");
                    break;
                }
                case 4: {
                    // Find note by id
                    List<NoteModel> notes = repository.getAll();
                    if (notes.isEmpty()) {
                        System.out.println("There is no any note here");
                        break;
                    }
                    repository.search("Enter index which you want to show...");
                    int index = Integer.parseInt(menuScanner.next()) - 1;

                    String targetId = notes.get(index).getId();

                    NoteModel result = repository.findById(targetId);

                    System.out.println("\t\tNote Detail");
                    System.out.println(
                            "Id: " + result.getId() +
                                    "\nTitle: " + result.getTitle() +
                                    "\nContent: " + result.getContent() +
                                    "\nPublishDate: " + result.getPublishDateInMillis()
                    );
                    break;
                }
                case 5: {
                    // Get all notes
                    List<NoteModel> dataSource = repository.getAll();
                    if (dataSource.isEmpty()) {
                        System.out.println("No notes found to list.");
                    }
                    repository.addDate();
                }
            }
        }
    }
}
