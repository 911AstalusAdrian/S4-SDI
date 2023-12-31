import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {StudentDetailComponent} from "./students/student-detail/student-detail.component";
import {StudentsComponent} from "./students/students.component";
import {StudentListComponent} from "./students/student-list/student-list.component";
import {StudentService} from "./students/shared/student.service";
import { DisciplinesComponent } from './disciplines/disciplines.component';
import { DisciplinesListComponent } from './disciplines/disciplines-list/disciplines-list.component';
import {DisciplineService} from "./disciplines/shared/discipline.service";
import { DisciplineNewComponent } from './disciplines/discipline-new/discipline-new.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentDetailComponent,
    StudentsComponent,
    StudentListComponent,
    DisciplinesComponent,
    DisciplinesListComponent,
    DisciplineNewComponent,



  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [StudentService, DisciplineService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
