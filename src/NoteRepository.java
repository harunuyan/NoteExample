import Model.NoteModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteRepository implements INoteManager {

    private final ArrayList<NoteModel> notes = new ArrayList<>();

    @Override
    public void add(NoteModel note) {
        notes.add(note);
    }

    @Override
    public void update(String targetId, NoteModel newNote) {
        for (NoteModel note : notes) {
            if (note.getId().equals(targetId)) {
                int index = notes.indexOf(note);
                notes.set(index, newNote);
            }
        }
    }

    @Override
    public void delete(String targetId) {
        notes.removeIf(item -> item.getId().equals(targetId));
    }

    @Override
    public List<NoteModel> getAll() {
        return notes;
    }

    @Override
    public NoteModel findById(String targetId) {
        for (NoteModel note : notes) {
            if (note.getId().equals(targetId)) {
                return note;
            }
        }
        return null;
    }

    public void showWithMessage(String message) {
        for (int i = 0; i < notes.size(); i++) {
            System.out.println(i + 1 + "-" + notes.get(i).getTitle() + "\n" + notes.get(i).getContent());
        }

        System.out.println(message);
    }

    public void showWithDate(List<NoteModel> noteList) {
        Date dateForPublish = new Date();
        for (int i = 0; i < noteList.size(); i++) {
            NoteModel n = noteList.get(i);
            dateForPublish.setTime(n.getPublishDateInMillis());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");

            System.out.println(
                    i + 1 + "-" + n.getTitle() + " (" + formatter.format(dateForPublish) + ")"
            );
        }
    }
}
