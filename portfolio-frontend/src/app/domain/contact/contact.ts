import {Component, OnInit} from '@angular/core';
import {Hero} from '../../core/layout/hero/hero';
import {FormBuilder, FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import {GenericInput} from '../../shared/components/generic-input/generic-input';
import {MailFormControl} from '../../shared/models/mailFormControl.model';
import {MatButton} from '@angular/material/button';
import {MailService} from '../../core/services/MailService/mail-service';
import {Mail} from '../../shared/models/mail.model';

@Component({
  selector: 'app-contact',
  imports: [
    Hero,
    FormsModule,
    ReactiveFormsModule,
    GenericInput,
    MatButton
  ],
  templateUrl: './contact.html',
  styleUrl: './contact.scss'
})
export class Contact {
  public formFields: MailFormControl[] = [
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "First name",
      "placeholder": "",
      "required": true,
      "controlName": "firstName"
    },
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "Last name",
      "placeholder": "",
      "required": true,
      "controlName": "lastName"
    },
    {
      "control": new FormControl(''),
      "type": "email",
      "label": "E-mail",
      "placeholder": "example@gmail.com",
      "required": true,
      "controlName": "email"
    },
    {
      "control": new FormControl(''),
      "type": "phone",
      "label": "Phone",
      "placeholder": "+(XX) XXXXX-XXXX",
      "required": false,
      "controlName": "phone"
    },
    {
      "control": new FormControl(''),
      "type": "text",
      "label": "Subject",
      "placeholder": "",
      "required": true,
      "controlName": "subject"
    },
    {
      "control": new FormControl(''),
      "type": "textarea",
      "label": "Message",
      "placeholder": "",
      "required": true,
      "controlName": "message"
    }
  ];

  public form: FormGroup;
  private mailService : MailService;

  constructor(public formBuilder: FormBuilder, mailService: MailService) {
    this.form = formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      phone: [''],
      subject: ['', Validators.required],
      message: ['', Validators.required]
    });
    this.mailService = mailService;
  }

  private preparePayload() : Mail{
    return this.form.value as Mail;
  }

  public getControl(name: string): FormControl {
    return this.form.get(name) as FormControl;
  }

  onSubmit() {
    this.mailService.sendMail(this.preparePayload()).subscribe({
        error: err => {
          console.error(`There was an error when trying to submit the e-mail" ${err.message}`);
        },
        complete: () => {
          console.log('Successfully submitted email!');
        }
      }
    )
  }

  protected readonly onsubmit = onsubmit;
}
