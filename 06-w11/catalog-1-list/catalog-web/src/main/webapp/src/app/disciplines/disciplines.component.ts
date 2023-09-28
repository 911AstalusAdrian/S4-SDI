import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-disciplines',
  templateUrl: './disciplines.component.html',
  styleUrls: ['./disciplines.component.css']
})
export class DisciplinesComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  addDiscipline() {
    this.router.navigate(['/discipline-new']);
  }
}
