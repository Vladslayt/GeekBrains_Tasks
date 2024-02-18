from data_create import input_user_data


def input_data():
    name, surname, phone, adress = input_user_data()
    var = int(input(f'\nВ каком формате записать данные? \n'
                    f'1 Вариант:\n'
                    f'{name}\n'
                    f'{surname}\n'
                    f'{phone}\n'
                    f'{adress}\n\n'
                    f'2 Вариант:\n'
                    f'{name};{surname};{phone};{adress}\n\n'
                    f'Ваш выбор: '))
    if var == 1:
        with open('data_first_variant.csv', 'a', encoding='utf-8') as file:
            file.write( f'{name}\n'
                        f'{surname}\n'
                        f'{phone}\n'
                        f'{adress}\n\n')
    else:
        with open('data_second_variant.csv', 'a', encoding='utf-8') as file:
            file.write(f'{name};{surname};{phone};{adress}\n\n')

def print_data():
    print('1 файл:')
    with open('data_first_variant.csv', 'r', encoding='utf-8') as file:
        data = file.readlines()
        print(''.join(data))
        
    print('2 файл:')
    with open('data_second_variant.csv', 'r', encoding='utf-8') as file:
        data = file.readlines()
        print(''.join(data))


def copy_data():
    print('Из какого файла будем копировать? \n'
        '1 - Первый файл(data_first_variant) \n'
        '2 - Второй файл(data_second_variant)')
    var = int(input('Ваш выбор: '))
    
    if var == 1:
        source_file = 'data_first_variant.csv'
    else:
        source_file = 'data_second_variant.csv'

    print('В какой файл будем записывать? \n'
        '1 - Первый файл(data_first_variant) \n'
        '2 - Второй файл(data_second_variant)')
    var = int(input('Ваш выбор: '))
    
    if var == 1:
        destination_file = 'data_first_variant.csv'
    else:
        destination_file = 'data_second_variant.csv'

    record_number = int(input('Какую строчку копируем: '))

    with open(source_file, 'r', encoding='utf-8') as src:
        lines = src.readlines()

        if record_number < 1 or record_number > len(lines):
            print(f"Запись с номером {record_number} не найдена.")
            return

        data_to_copy = lines[record_number - 1]

    with open(destination_file, 'a', encoding='utf-8') as dest:
        # Добавляем данные в конец файла
        dest.write(data_to_copy)

    print(f"Данные из записи {record_number} скопированы в {destination_file}.")

