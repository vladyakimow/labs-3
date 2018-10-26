#include <stdafx.h>
#include <stdio.h>

const int labyrinthHeight = 9;
const int labyrinthWidth = 9;

char labyrinth[labyrinthHeight][labyrinthWidth + 1] =
{
    "# #######",
    "#   #   #",
    "# ### # #",
    "# #   # #",
    "# # # ###",
    "#   # # #",
    "# ### # #",
    "#   #   #",
    "####### #",
};

const char Wall = '#';
const char Free = ' ';
const char Tochka = '*';

class COORD
{
public:
    int X;
    int Y;
    COORD(int x = 0, int y = 0) { X = x, Y = y; }
    COORD(const COORD &coord) { X = coord.X; Y = coord.Y; }
};

COORD StartingPoint(1, 0);
COORD EndingPoint(7, 8);

void PrintDalabyrinth()
{
    for (int Y = 0; Y < labyrinthHeight; Y++)
    {
        printf("%s\n", labyrinth[Y]);
    }
    printf("\n");
}

bool Solve(int X, int Y)
{
    labyrinth[Y][X] = Tochka;
    
    if (X == EndingPoint.X && Y == EndingPoint.Y)
    {
        return true;
    }

    if (X > 0 && labyrinth[Y][X - 1] == Free && Solve(X - 1, Y))
    {
        return true;
    }
    if (X < labyrinthWidth && labyrinth[Y][X + 1] == Free && Solve(X + 1, Y))
    {
        return true;
    }
    if (Y > 0 && labyrinth[Y - 1][X] == Free && Solve(X, Y - 1))
    {
        return true;
    }
    if (Y < labyrinthHeight && labyrinth[Y + 1][X] == Free && Solve(X, Y + 1))
    {
        return true;
    }

    labyrinth[Y][X] = Free;

    return false;
}

int _tmain(int argc, _TCHAR* argv[])
{
    if (Solve(StartingPoint.X, StartingPoint.Y))
    {
        PrintDalabyrinth();
    }
    else
    {
        printf("Tochka\n");
    }

    return 0;
}
