import {FormControl} from '@angular/forms';

export interface MailFormControl {
  control: FormControl;
  controlName: string;
  type: string;
  placeholder: string;
  label: string;
  required: boolean;
}
