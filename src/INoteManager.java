import Model.NoteModel;

import java.util.List;

public interface INoteManager {
    void add(NoteModel note);

    void update(String targetId, NoteModel newNote);

    void delete(String targetId);

    List<NoteModel> getAll();

    NoteModel findById(String targetId);
}
