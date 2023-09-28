import {Component, OnInit} from '@angular/core';
import {DisciplineService} from '../shared/discipline.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-discipline-new',
  templateUrl: './discipline-new.component.html',
  styleUrls: ['./discipline-new.component.css']
})
export class DisciplineNewComponent implements OnInit {

  constructor(private disciplineService: DisciplineService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  saveDiscipline(title: string, teacher: string, credits: string) {
    this.disciplineService.saveDiscipline({id: 0, title, teacher, credits: +credits})
      .subscribe(_ => this.router.navigate(['/disciplines']));
  }
}
