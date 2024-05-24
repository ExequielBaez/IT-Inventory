import { Component, OnInit } from '@angular/core';
import { Element } from 'src/app/common/element';
import { ElementService } from 'src/app/services/element.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  elements: Element [] = [];

  constructor(private elementService:ElementService){

  }

  ngOnInit(): void {    
    this.elementService.getElements().subscribe(
      data => {this.elements = data
        console.log(this.elements)
      }
    );
    
    
  }   
}
