import { Component } from '@angular/core';
import { Hero } from "../../core/layout/hero/hero";

@Component({
  selector: 'app-not-found',
  imports: [Hero],
  templateUrl: './not-found.html',
  styleUrl: './not-found.scss'
})
export class NotFound {

}
