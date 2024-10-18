package webProgramming.lab3v1.userInterface.impl;

import webProgramming.lab3v1.handlers.IOHandler;
import webProgramming.lab3v1.handlers.impl.ConsoleHandler;
import webProgramming.lab3v1.menus.Menu;
import webProgramming.lab3v1.menus.impl.MainMenu;
import webProgramming.lab3v1.shapes.Shape;
import webProgramming.lab3v1.state.State;
import webProgramming.lab3v1.state.impl.MainState;
import webProgramming.lab3v1.storage.ShapeStorage;
import webProgramming.lab3v1.userInterface.UserInterface;
/*
[1] Создать фигуру
    [1.1] Создать треугольник
    [1.2] Создать прямоугольник
    [1.3] Создать правильный шестиугольник
        [1.3.1] Введите название
        [1.3.2] Введите длину стороны
[2] Вывести информацию
    [2.1] Вывести информацию о фигуре
        [2.1.1] Введите индекс фигуры
        [2.1.2] Введите название фигуры
    [2.2] Вывести информацию о площадях фигур
    [2.3] Вывести всю информацию о всех фигурах
[3] Определить средний размер периметра фигур с количеством сторон больше 5
[4] Упорядочить массив по возрастанию площади
[5] Изменить свойство фигуры
    [5.1] Изменить название фигуры
[q] Выход
 */
/**
 * Класс ShapesUI позволяет
 * взаимодействовать с пользователем для работы с
 * классами геометрических фигур
 */
public class ShapesUI implements UserInterface {
    private final IOHandler _ioHandler;

    private final ShapeStorage _shapeStorage;

    private Menu _menu;

    private State _state;

    private Shape _currentShape;

    /**
     * конструктор по умолчанию
     */
    public ShapesUI() {
        _ioHandler = new ConsoleHandler();
        _shapeStorage = new ShapeStorage();
        _menu = new MainMenu();
        _state = new MainState();
        _currentShape = null;
    }

    public void run() {
        char command;
        do{
            _ioHandler.write(_menu.getMenu());

            _ioHandler.write("Введите команду: ");
            command = _ioHandler.read().charAt(0);
            if(command == 'q'){
                break;
            }

            _state.handleState(this, command);
        }while(true);
        _ioHandler.write("Работа завершена!");
    }

    public void setMenu(Menu menu) {
        this._menu = menu;
    }

    public ShapeStorage getShapeStorage() {
        return _shapeStorage;
    }

    public IOHandler getIoHandler() {
        return _ioHandler;
    }

    public void setCurrentShape(Shape currentShape) {
        this._currentShape = currentShape;
    }

    public void setState(State state) {
        this._state = state;
    }

}
