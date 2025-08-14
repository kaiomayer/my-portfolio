import { Component } from '@angular/core';
import { Card } from '../../core/layout/card/card';
import {Hero} from '../../core/layout/hero/hero';


@Component({
  selector: 'app-projects',
  imports: [Card, Hero],
  templateUrl: './projects.html',
  styleUrl: './projects.scss'
})

export class Projects {

}
