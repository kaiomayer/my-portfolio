import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-edit',
  imports: [
    ReactiveFormsModule,
    MatButton
  ],
  templateUrl: './edit.html',
  styleUrl: './edit.scss'
})
export class Edit implements OnInit {
  public personalForm : FormGroup;
  public projectForm : FormGroup;
  public experienceForm : FormGroup;

  constructor(fb : FormBuilder) {
    this.personalForm = fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      bio: ['', Validators.required],
      description: ['', Validators.required]
    });

    this.projectForm = fb.group({
      title: ['', Validators.required],
      startDate: ['', Validators.required],
      description: ['', Validators.required],
      url: ['', Validators.required]
    });

    this.experienceForm = fb.group({
      position: ['', Validators.required],
      company: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    console.log("Fetching user data");
  }

  onSubmitPersonal() {

  }

  onSubmitProjects() {

  }

  onSubmitExperience() {

  }

}
