import {Component, OnInit} from '@angular/core';
import {EmpresasService} from "../empresas.service";
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas-list.component.html',
  styleUrls: ['./empresas-list.component.scss']
})
export class EmpresasListComponent implements OnInit {

  displayedColumns: string[] = ['id', 'nome', 'cnpj', 'acoes'];
  dataSource: Array<any> = new Array<any>();

  constructor(private empresasService: EmpresasService) {
  }

  ngOnInit(): void {
    this.listarEmpresas()
  }

  listarEmpresas() {
    this.empresasService.listarEmpresas().subscribe(empresas => {
      this.dataSource = empresas["content"]
    }, error => {
      console.log('Erro ao listar as empresas', error);
    })
  }

}
