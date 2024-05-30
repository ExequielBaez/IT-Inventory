import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ElementService } from 'src/app/services/element.service';

@Component({
  selector: 'app-element-detail',
  templateUrl: './element-detail.component.html',
  styleUrls: ['./element-detail.component.css']
})
export class ElementDetailComponent implements OnInit{

  idElement : string = "";
  nameElement : string = "";
  brand : string = "";
  cpu:string ="";
  mother:string ="";
  hdd:string ="";
  memory:string ="";
  so:string ="";
  ipNumber:string ="";
  workplace:string ="";
  antivirus:string ="";
  urlImage:string ="";

  constructor(private elementService: ElementService,
              private activatedRoute: ActivatedRoute){

  }

  ngOnInit(): void {
    this.getElementById();
  }

  getElementById(){
    this.activatedRoute.params.subscribe(
      e => {
        let id = e['id'];
        if(id){
          this.elementService.getElementById(id).subscribe(
            data =>{
            this.nameElement = data.nameElement;
            this.brand = data.brand;
            this.cpu = data.cpu;
            this.mother = data.mother;
            this.hdd = data.hdd;
            this.memory = data.memory;
            this.so = data.so;
            this.ipNumber = data.ipNumber;
            this.workplace = data.workplace;
            this.antivirus = data.antivirus;
            this.urlImage = data.urlImage;

            }
          );
        }
      }
    );
  }

 

}
