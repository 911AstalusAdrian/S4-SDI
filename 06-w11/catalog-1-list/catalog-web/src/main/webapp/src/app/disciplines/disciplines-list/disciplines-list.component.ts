import {Component, OnInit} from '@angular/core';
import {DisciplineService} from "../shared/discipline.service";
import {Discipline} from "../shared/discipline.model";
import {Location} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-disciplines-list',
  templateUrl: './disciplines-list.component.html',
  styleUrls: ['./disciplines-list.component.css']
})
export class DisciplinesListComponent implements OnInit {
  disciplines: Discipline[] = [];

  constructor(private disciplineService: DisciplineService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.disciplineService.getDisciplines().subscribe(
      disciplines => this.disciplines = disciplines
    );
  }


  deleteDiscipline(discipline: Discipline) {
    this.disciplineService.deleteDiscipline(discipline.id)
      .subscribe(_ => this.disciplines = this.disciplines.filter(d => d.id !== discipline.id));
  }
}
