import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ElementService } from 'src/app/services/element.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-element-add',
  templateUrl: './element-add.component.html',
  styleUrls: ['./element-add.component.css']
})
export class ElementAddComponent implements OnInit{
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
  idUser:string ="";
  idCategory:string ="";

  selectFile! : File;

  constructor(private elementService : ElementService,
              private router : Router,
              private activatedRoute : ActivatedRoute
  ){

  } 
  
  ngOnInit(): void {
    this.getElementById();
   
  }
  
  addElement(){
    const formData = new FormData();
    formData.append('idElement', this.idElement);
    formData.append('nameElement', this.nameElement);
    formData.append('brand', this.brand);
    formData.append('cpu',this.cpu);
    formData.append('mother',this.mother);
    formData.append('hdd',this.hdd);
    formData.append('memory', this.memory);
    formData.append('so',this.so);
    formData.append('ipNumber', this.ipNumber);
    formData.append('workplace',this.workplace);
    formData.append('antivirus', this.antivirus);
    formData.append('image', this.selectFile)
    formData.append('urlImage', this.urlImage);
    formData.append('idUser',this.idUser);
    formData.append('idCategory',this.idCategory);
    console.log(formData);
    
    this.elementService.createElement(formData).subscribe(
      data => {
        console.log(data);
        if(this.idElement == ""){

          Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Equipo Creado!",
            showConfirmButton: false,
            timer: 1500
          });

        }else{

          Swal.fire({
            position: "top-end",
            icon: "success",
            title: "Equipo Modificado!",
            showConfirmButton: false,
            timer: 1500
          });

        }
        this.router.navigate(['admin/element']);  
      }
    );

    
        
  }

  getElementById(){
    this.activatedRoute.params.subscribe(
      element => {
        let id = element['id'];
        if(id){
          console.log('el valor id es: '+id);
          this.elementService.getElementById(id).subscribe(
            data =>{
              this.idElement = data.idElement;
              this.nameElement = data.nameElement;
              this.brand  = data.brand;
              this.cpu = data.cpu;
              this.mother = data.mother;
              this.hdd = data.hdd;
              this.memory = data.memory;
              this.so = data.so;
              this.ipNumber = data.ipNumber;
              this.workplace = data.workplace;
              this.antivirus = data.antivirus
              this.urlImage = data.urlImage;
              this.idUser = data.idUser;
              this.idCategory = data.idCategory;
            }
          );
        }
      }
    );
  }

  onFileSelected(event : any){
    this.selectFile = event.target.files[0];
  }
}
