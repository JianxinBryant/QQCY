/**
 * Created by Teacher on 2016/12/25.
 */
/**
 * ȫѡ�뷴ѡ
 */
function checkedOrUnchecked(thisz) {
    //������������еĸ�ѡ��
    var idsArr = document.getElementsByName("ids");
    //ѭ���޸�ѡ��״̬����
    for(i=0; i<idsArr.length; i++) {
        idsArr[i].checked = thisz.checked;
    }
}

/**
 * ���ѡ�и�ѡ�������
 */
function getSelectedCount() {
    //������������еĸ�ѡ��
    var idsArr = document.getElementsByName("ids");
    //ѡ�и�ѡ�������
    var count = 0;
    //ѭ��ͳ��ѡ�и�ѡ�������
    for(i=0; i<idsArr.length; i++) {
        if(idsArr[i].checked) {
            count++;
        }
    }
    //��������
    return count;
}

/**
 * ���
 */
function add() {
    /*//��ñ�����
    var form = document.getElementById("form2");
    //�����ύ��·��
    form.action = "useradd.html";
    //�ύ��
    form.submit();*/
    location.href = "useradd.html";
}

/**
 * �޸�
 */
function update() {
    //���ѡ�е�����
    var count = getSelectedCount();
    //�ж��Ƿ�����ύ��
    if(count!=1) {
        alert("��ѡ��һ��Ҫ�޸ĵļ�¼!");
        return;
    }
    //��ñ�����
    var form = document.getElementById("form2");
    //�����ύ��·��
    form.action = "userupdate.html";
    //�ύ��
    form.submit();
}

/**
 * ɾ��
 */
function deleted() {
    //���ѡ�е�����
    var count = getSelectedCount();
    //�ж��Ƿ�ѡ����������
    if(count==0) {
        alert("��ѡ��Ҫɾ���ļ�¼!");
        return;
    }
    //����ѡ��Ի���
    if(confirm("���Ƿ�Ҫɾ��ѡ�еļ�¼?")) {
        //��ñ�����
        var form = document.getElementById("form2");
        //�����ύ��·��
        form.action = "";
        //�ύ��
        form.submit();
    }
}