import json
import os
import datetime

NOTES_FILE = "notes.json"


def load_notes():
    if os.path.exists(NOTES_FILE):
        with open(NOTES_FILE, "r") as file:
            return json.load(file)
    else:
        return []


def save_notes(notes):
    with open(NOTES_FILE, "w") as file:
        json.dump(notes, file, indent=4)


def add_note():
    notes = load_notes()
    note_id = len(notes) + 1
    title = input("Введите заголовок заметки: ")
    body = input("Введите текст заметки: ")
    created_at = datetime.datetime.now().isoformat()
    note = {"id": note_id, "title": title, "body": body, "created_at": created_at}
    notes.append(note)
    save_notes(notes)
    print("Заметка успешно добавлена.")


def edit_note():
    notes = load_notes()
    note_id = int(input("Введите ID заметки для редактирования: "))
    for note in notes:
        if note["id"] == note_id:
            title = input("Новый заголовок заметки: ")
            body = input("Новый текст заметки: ")
            note["title"] = title
            note["body"] = body
            note["updated_at"] = datetime.datetime.now().isoformat()
            save_notes(notes)
            print("Заметка успешно отредактирована.")
            return
    print("Заметка с указанным ID не найдена.")


def delete_note():
    notes = load_notes()
    note_id = int(input("Введите ID заметки для удаления: "))
    for note in notes:
        if note["id"] == note_id:
            notes.remove(note)
            save_notes(notes)
            print("Заметка успешно удалена.")
            return
    print("Заметка с указанным ID не найдена.")


def list_notes():
    notes = load_notes()
    for note in notes:
        print(f"ID: {note['id']}, Заголовок: {note['title']}, Текст: {note['body']}, Создано: {note['created_at']}")
    if not notes:
        print("Заметок нет.")


def find_notes_by_date():
    notes = load_notes()
    date_str = input("Введите дату в формате ГГГГ-ММ-ДД: ")
    try:
        date = datetime.datetime.strptime(date_str, "%Y-%m-%d")
    except ValueError:
        print("Неверный формат даты.")
        return
    found_notes = [note for note in notes if
                   note.get("created_at") and date.date() == datetime.datetime.fromisoformat(note["created_at"]).date()]
    if found_notes:
        print("Найденные заметки:")
        for note in found_notes:
            print(f"ID: {note['id']}, Заголовок: {note['title']}, Текст: {note['body']}, Создано: {note['created_at']}")
    else:
        print("Заметок за указанную дату нет.")


def main():
    while True:
        print(
            "\nКоманды: add - добавить заметку, edit - редактировать заметку, delete - удалить заметку, list - список "
            "заметок, find - поиск по дате, exit - выход.")
        command = input("Введите команду: ").strip().lower()
        if command == "add":
            add_note()
        elif command == "edit":
            edit_note()
        elif command == "delete":
            delete_note()
        elif command == "list":
            list_notes()
        elif command == "find":
            find_notes_by_date()
        elif command == "exit":
            print("Выход из программы.")
            break
        else:
            print("Некорректная команда.")


if __name__ == "__main__":
    main()
