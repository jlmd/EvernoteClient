package com.jlmd.android.evernoteclient.app.di;

import com.evernote.client.android.EvernoteSession;
import com.googlecode.tesseract.android.TessBaseAPI;
import com.jlmd.android.evernoteclient.app.navigator.Navigator;
import com.jlmd.android.evernoteclient.domain.interactor.addnote.AddNote;
import com.jlmd.android.evernoteclient.domain.interactor.noteslist.GetNotesList;
import com.jlmd.android.evernoteclient.presentation.addnote.AddNotePresenter;
import com.jlmd.android.evernoteclient.presentation.login.LoginPresenter;
import com.jlmd.android.evernoteclient.presentation.main.MainPresenter;
import com.jlmd.android.evernoteclient.presentation.notedetails.NoteDetailsPresenter;
import com.jlmd.android.evernoteclient.presentation.noteslist.NotesListPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module which provides presenters
 *
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public final class PresenterModule {

  @Provides
  LoginPresenter provideLoginPresenter(Navigator navigator) {
    return new LoginPresenter(navigator);
  }

  @Provides
  MainPresenter provideMainPresenter(Navigator navigator, EvernoteSession evernoteSession) {
    return new MainPresenter(navigator, evernoteSession);
  }

  @Provides
  NotesListPresenter provideNotesListPresenter(GetNotesList getNotesList, Navigator navigator) {
    return new NotesListPresenter(getNotesList, navigator);
  }

  @Provides
  NoteDetailsPresenter provideNoteDetailsPresenter(Navigator navigator) {
    return new NoteDetailsPresenter(navigator);
  }

  @Provides
  AddNotePresenter provideAddNotePresenter(AddNote addNote, Navigator navigator,
      TessBaseAPI tessBaseAPI) {
    return new AddNotePresenter(navigator, addNote, tessBaseAPI);
  }
}