#include <iostream>
#include <string>
#include<ctime>
#include<cstdlib>
#include <algorithm>
#include <iomanip>
using namespace std;

void table();
string dateequally(string date);
class record {
	int id = 0;
	string from, to, date, time, duration;
public:
	void inInformation() {

		for (int i = 0; i < 6; i++) {
			id = id * 10 + rand() % 10;
		}
	cout << "Enter sender name:" << endl;
	cin >> from;
	cout << "Enter the name of the recipient:" << endl;
	cin >> to;
	cout << "Enter data:" << endl;
	cin >> date;
	cout << "Enter start time:" << endl;
	cin >> time;
	cout << "Enter duration:" << endl;
	cin >> duration;
	}
	void parInInformation(string from, string to, string date, string time, string duration) {
		for (int i = 0; i < 6; i++) {
			id = id * 10 + rand() % 10;
		}
		this->from = from;
		this->to = to;
		this->date = date;
		this->time = time;
		this->duration = duration;
	}
	
	void outInformation() {
		cout << setw(7) << id << setw(15) << left << from
			<< setw(15) << to
			<< setw(11) << date
			<< setw(6) << time
			<< setw(9) << duration
			<< endl;
	}
	int idout() {
	return id;
	}
	string timeout() {
	return time;
	}
	string fromout() {
	return from;
	}
	string toout() {
	return to;
	}
	string durout() {
	return duration;
	}
	string dateout() {
	return dateequally(date);
	}

};
	bool idsort(record& record1, record& record2) {
	return record1.idout() < record2.idout();
	}
	bool timesort(record& record1, record& record2) {
	return record1.timeout() < record2.timeout();
	}
	bool namesort1(record& record1, record& record2) {
	return record1.fromout() < record2.fromout();
	}
	bool namesort2(record& record1, record& record2) {
	return record1.toout() < record2.toout();
	}
	bool dursort(record& record1, record& record2) {
	return record1.durout() < record2.durout();
	}
	bool datesort(record& record1, record& record2) {
	return record1.dateout() < record2.dateout();
	}

int main()
{	
	srand(time(NULL));
	int y = 3, n = 9, del;
	table();
	record t[30];
	t[0].parInInformation("Vladislav", "Anastasya", "14.10.2018", "20:28", "13");
	t[1].parInInformation("Sergey", "Dmitriy", "14.10.2018", "13:56", "40");
	t[2].parInInformation("Max", "Vadim", "13.09.2018", "18:17", "23");
	while (n != 0) {
		system("cls");
		table();
		for (int i = 0; i < y; i++) {
			t[i].outInformation();
		}
		cout << "\n\nOperations:\n1)add\n2)delete\n3)show\n4)sort\n5)from date to date\n6)from dur to dur\n7)from\n8)to\n0)exit" << endl;
		cin >> n;
		if (n == 1) {
			t[y].inInformation();
			y++;
		}
		if (n == 2) {
			cout << "Input id\n";
			cin >> del;
			for (int i = 0; i < y; i++) {
				if (t[i].idout() == del) {
					if (y == i) {
						y--;
					}
					else {
						for (int j = i; j < y - 1; j++) {
							t[j] = t[j + 1];
						}
						y--;
					}
				}
			}
		}
		if (n == 3) {
			system("cls");
			table();
			for (int i = 0; i < y; i++) {
				t[i].inInformation();
			}
			system("pause");
	}
	if (n == 4) {
		system("cls");
		cout << "Sort:\n1)time\n2)id\n3)from\n4)to\n5)duration\n6)date\n";
		int p;
		cin >> p;
		if (p == 1) {
			sort(t, t + y, timesort);
		}
		if (p == 2) {
			sort(t, t + y, idsort);
		}
		if (p == 3) {
			sort(t, t + y, namesort1);
		}
		if (p == 4) {
			sort(t, t + y, namesort2);
		}
		if (p == 5) {
				sort(t, t + y, dursort);
		}
		if (p == 6) {
				sort(t, t + y, datesort);
		}
	} 
	if (n == 5) {
		system("clas");
		string fromdate, todate;
		cout << "Input: from date\n";
		cin >> fromdate;
		cout << "Input: to date\n";
		cin >> todate;
		system("clas");
		table();
		for (int i = 0; i < y; i++) {
			if (dateequally(fromdate) <= t[i].dateout() && dateequally(todate) >= t[i].dateout()) {
				t[i].outInformation();
			}
		}
		system("pause");
	}
	if (n == 6) {
		system("clas");
		string fromdur, todur;
		cout << "Input: from duration\n";
		cin >> fromdur;
		cout << "Input: to duration\n";
		cin >> todur;
		system("clas");
		table();
		for (int i = 0; i < y; i++) {
			if (t[i].durout() >= fromdur && t[i].durout() <= todur) {
				t[i].outInformation();
			}
		}
			system("pause");
		}
	if (n == 7) {
		system("clas");
		string name;
		cout << "Input name\n";
		cin >> name;
		system("clas");
		table();
		for (int i = 0; i < y; i++) {
			if (name == t[i].fromout()) {
				t[i].outInformation();
			}
		}
		system("pause");
	}
	if (n == 8) {
		system("clas");
		string name;
		cout << "Input name\n";
		cin >> name;
		system("clas");
		table();
		for (int i = 0; i < y; i++) {
			if (name == t[i].toout()) {
				t[i].outInformation();
				}
			}
			system("pause");
		}
		
	}
	return 0;
}

	void table() {
		cout << setw(7) << "id# " << setw(15) << left << "from"
			<< setw(15) << "to"
			<< setw(11) << "date"
			<< setw(6) << "time"
			<< setw(9) << "duration"
			<< endl;
}
	string dateequally(string date) {
		string p;
		p = date[6] + date[7] + date[8] + date[9] + '.' + date[3] + date[4] + '.' + date[0] + date[1];
return p;
