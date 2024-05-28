import { Component, OnInit } from '@angular/core';
import { ElementService } from 'src/app/services/element.service';
import { Element } from 'src/app/common/element';

@Component({
  selector: 'app-element-list',
  templateUrl: './element-list.component.html',
  styleUrls: ['./element-list.component.css']
})
export class ElementListComponent implements OnInit {

  elements : Element[] = [];

  constructor(private elementService:ElementService ){}

  ngOnInit(): void {   
     this.listElements();
  }

  listElements(){

    this.elementService.getElements().subscribe(
      data => {
        this.elements = data;
        console.log(data);
      }
    );
  }

  deleteElementById(idElement:string){
    this.elementService.deleteElementById(idElement).subscribe(
        ()=>this.listElements()
    );

  }

}
